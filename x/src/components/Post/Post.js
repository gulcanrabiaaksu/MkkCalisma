import React, {useState,useRef,useEffect} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import FavoriteIcon from '@mui/icons-material/Favorite';
import CommentIcon from '@material-ui/icons/Comment';
import Comment from "../Comment/Comment";
import Container from '@material-ui/core/Container';
import CommentForm from '../Comment/CommentForm';


const useStyles = makeStyles((theme) => ({
  root: {
    width:800,
    textAlign : "left",
    margin: 20,
  },
  media: {
    height : 0,
    paddingTop:'56.25%',
  },
  expand: {
   transform: 'rotate(Odeg)',
    marginLeft:'auto',
    transition: theme.transitions.create('transfrom', {
    duration: theme.transitions.duration.shortest,
    }),
  },
  avatar: {
    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
  },
}));


function Post(props){
    const {title,text, userName,postId, likes , userId} =props;
    const classes =useStyles();
    const[expanded, setExpanded] = useState(false); 
    const [error,setError] =useState(null);
    const [isLoaded,setIsLoaded] =useState(false);
    const isInitialMount = useRef(true); //ilk kez mi load ediliyor biri tıkladı mı söyler
    const [commentList,setCommentList] =useState([]);
    //const [refresh, setRefresh] = useState(false);
    const [likeCount, setLikeCount] = useState(likes.length);
    const [isLiked,setisLiked] =useState(false);

    const handleExpandClick= () => {
        setExpanded(!expanded);
        refreshComents();
        console.log(commentList);
        
    };
    const handleLike = ()=>{
      setisLiked(!isLiked);
      if(!isLiked){
        saveLike();
        setLikeCount(likeCount + 1)
      }
      else{
        deleteLike();
        setLikeCount(likeCount - 1)
      }
        
     }
     
    
  

    const refreshComents = ()=> {
      fetch('http://localhost:3000/comments?postId=' + postId)//yanında post ıd de var cunku sadece posta ait commentleri cekicez
      .then(res =>res.json())
      .then(//iki ihtimal var result ve error
          (result) => {
              setIsLoaded(true);//data geldi
              setCommentList(result);//gelen resultu ata
          },
          (error) =>{
              console.log(error)
              setIsLoaded(true);//sayfa donerde kalmaz yine true olucak,sayfa geldi
              setError(error);
          }
      )
  }
  
  const checkLikes= () => {
    var likeControl =likes.find((like => like.userId === userId));
    if(likeControl != null){
      setisLiked(likeControl.id);
      setisLiked(true);

  }
}
const saveLike = () => {
  fetch("/likes",{
    postId: postId, 
    userId : localStorage.getItem("currentUser"),
  })
    .then((res) => res.json())
    .catch((err) => console.log(err))
}

const deleteLike = () => {
  fetch("/likes/"+isLiked)
    .catch((err) => console.log(err))
}

  useEffect(()=> {
    if(isInitialMount.current)
    isInitialMount.current=false;
    else
    refreshComents();
  }, [commentList])

  useEffect(()=>{checkLikes()},[])

    return(
        <Card className={classes.root}>
        <CardHeader
        avatar ={
          
             <Avatar aria-label="recipe"  className={classes.avatar} >
               {userName.charAt(0).toUpperCase()}
              </Avatar>
          
          }
          title={title} 
          />
        <CardContent>
          <Typography variant="body2" color="textSecondary" component="p">
            {text}
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton 
          onClick={handleLike}
          aria-label="add to favorites"
          >
            <FavoriteIcon style={isLiked?{ color:"red"} : null} />
          </IconButton>
          {likeCount}
          <IconButton
          className = {clsx(classes.expand, {
            [classes.expandOpen]: expanded,
          })}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more" 
          >
            <CommentIcon />
            </IconButton>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
        <Container fixed className = {classes.container}>
          {error? "error" :
         isLoaded? commentList.map(comment => (
         <Comment userId = {1} userName = {"user"} text = {comment.text}></Comment>
           )) : "Loading"}
           <CommentForm userId = {1} userName = {"user"} postId = {postId}></CommentForm>
        </Container>
        </Collapse>
      </Card>
    
    )
}

export default Post;

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
import CommentIcon from '@mui/icons-material/Comment';
import Link from '@mui/icons-material/Link';


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
  expandOpen: {
    transform:'rotate(180deg)',
  },
  avatar: {
    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
  },
}));


function Post(props){
    const {title,text, userId, userName,postId} =props;
    const classes =useStyles();
    const[expanded, setExpanded] = useState(false); 
    const [liked,setLiked] =useState(false);
    const [error,setError] =useState(null);
    const [isLoaded,setIsLoaded] =useState(false);
    const isInitialMount = useRef(true);
    const [commentList,setPostList] =useState([]);

    const handleExpandClick= () => {
        setExpanded(!expanded);
        refreshComents();
        console.log(commentList);
    };
    const handleLike = ()=>{
      setLiked(!liked);

    }

    const refreshComents = ()=> {
      fetch("/comments?postId="+postId)//yanında post ııd de var cunku sadece posta ait commentleri cekicez
      .then(res =>res.json())
      .then(//iki ihtimal var result ve error
          (result) => {
              setIsLoaded(true);//data geldi
              setPostList(result);//gelen resultu ata
          },
          (error) =>{
              console.log(error)
              setIsLoaded(true);//sayfa donerde kalmaz yine true olucak,sayfa geldi
              setError(error);
          }
      )
  }
  
  useEffect(()=> {
    if(isInitialMount.current)
    isInitialMount.current=false;
    else
    refreshComents();
}, [commentList])

    return(
    <div className="postContainer">
        <Card className={classes.root}>
        <CardHeader
        avatar ={
        <Link className={classes.link} to = {{pathname :"/users/" + userId}}>
          <Avatar aria-label="recipe"  className={classes.avatar} >
            { userName.charAt(0).toUpperCase()}
            </Avatar>
            </Link>
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
          aria-label="add to favorites">
            <FavoriteIcon style={liked?{ color:"red"} : null} />
          </IconButton>
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
          <CardContent>
          </CardContent>
        </Collapse>
      </Card>
    </div>
    )
}

export default Post;

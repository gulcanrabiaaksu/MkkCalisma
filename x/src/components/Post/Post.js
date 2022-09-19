import React, {useState} from "react";
import { makeStyles } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
//import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, { IconButtonProps } from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import clsx from 'clsx';
//import { makeStyles } from '@mui/icons-material/styles';

/*import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import clsx from 'clsx';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import { red } from '@material-ui/core/colors';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';
*/
const useStyles =makeStyles((theme) => ({
  root: {
    maxwidth:345,
  },
  media: {
    height : 1,
    paddingTop:'56.25',
  },
  expand: {
    transform: 'rotate(Odeg)',
    marginLeft:'auto',
    transition: theme.transitions.create('transfrom', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    trasform: 'rotate(180deg)'
  },
  avatar: {
    backgroundColr:red[500],
  },
}));


function Post(props){
  const {title,text} =props;
  const classes =useStyles();
  const[expanded, setExpanded] = useState(false);

  const handleExpandClick= () => {
      setExpanded(!expanded);
  };

  return(
    <div className="postContainer">
       <Card className={classes.root}>
      <CardHeader
        avatar={
          <Avatar aria-label="recipe" className={classes.root} >
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={title}
        subheader="September 14, 2016"
      />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
          {text}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites">
          <FavoriteIcon />
        </IconButton>
        <IconButton aria-label="share">
          <ShareIcon />
        </IconButton>
        <IconButton
         className = {clsx(classes.expand, {
          [classes.expandOpen]: expanded,
         })}
         onClick={handleExpandClick}
         aria-expanded={expanded}
         aria-label="show more" 
        >
          <ExpandMoreIcon />
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

//dışardan erişmek isteyenler post ismiyle bu compentı cagırabilir

/*
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
import Container from '@material-ui/core/Container';
import FavoriteIcon from '@material-ui/icons/Favorite';
import CommentIcon from '@material-ui/icons/Comment';
import Comment from "../Comment/Comment";
import CommentForm from "../Comment/CommentForm";
import { PostWithAuth, DeleteWithAuth } from "../../services/HttpService";

const useStyles = makeStyles((theme) => ({
    root: {
      width: 800,
      textAlign : "left",
      margin : 20
    },
    media: {
      height: 0,
      paddingTop: '56.25%', // 16:9
    },
    expand: {
      transform: 'rotate(0deg)',
      marginLeft: 'auto',
      transition: theme.transitions.create('transform', {
        duration: theme.transitions.duration.shortest,
      }),
    },
    avatar: {
      background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
    },
    link: {
        textDecoration : "none",
        boxShadow : "none",
        color : "white"
    }
  }));

function Post(props) {
   const {title, text, userId, userName, postId, likes} = props;
   const classes = useStyles();
   const [expanded, setExpanded] = useState(false);
   const [error, setError] = useState(null);
   const [isLoaded, setIsLoaded] = useState(false);
   const [commentList, setCommentList] = useState([]);
   const [isLiked, setIsLiked] = useState(false);
   const isInitialMount = useRef(true);
   const [likeCount, setLikeCount] = useState(likes.length);
   const [likeId, setLikeId] = useState(null);
   const [refresh, setRefresh] = useState(false);
   let disabled = localStorage.getItem("currentUser") == null ? true:false;
   
   const setCommentRefresh = () => {
     setRefresh(true);
   }
   const handleExpandClick = () => {
     setExpanded(!expanded);
     refreshComments();
     console.log(commentList);
   };

   const handleLike = () => {
    setIsLiked(!isLiked);
    if(!isLiked){
      saveLike();
      setLikeCount(likeCount + 1)
    }
    else{
      deleteLike();
      setLikeCount(likeCount - 1)
    }
      
   }
   
   const refreshComments = () => {
    fetch("/api/comments?postId="+postId)
    .then(res => res.json())
    .then(
        (result) => {
            setIsLoaded(true);
            setCommentList(result)
        },
        (error) => {
            console.log(error)
            setIsLoaded(true);
            setError(error);
        }
    )

    setRefresh(false)
  }

  const saveLike = () => {
    PostWithAuth("/likes",{
      postId: postId, 
      userId : localStorage.getItem("currentUser"),
    })
      .then((res) => res.json())
      .catch((err) => console.log(err))
  }

  const deleteLike = () => {
    DeleteWithAuth("/likes/"+likeId)
      .catch((err) => console.log(err))
  }

  const checkLikes = () => {
    var likeControl = likes.find((like =>  ""+like.userId === localStorage.getItem("currentUser")));
    if(likeControl != null){
      setLikeId(likeControl.id);
      setIsLiked(true);
    }
  }
  useEffect(() => {
    if(isInitialMount.current)
      isInitialMount.current = false;
    else
      refreshComments();
  }, [refresh])

  useEffect(() => {checkLikes()},[])

   return(
           <Card className={classes.root}>
                <CardHeader
                    avatar={
                    <Link  className={classes.link} to={{pathname : '/users/' + userId}}>
                    <Avatar aria-label="recipe" className={classes.avatar}>
                        {userName.charAt(0).toUpperCase()}
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
                  {disabled ?                    
                  <IconButton 
                    disabled
                    onClick={handleLike}
                    aria-label="add to favorites"
                    >
                    <FavoriteIcon style={isLiked? { color: "red" } : null} />
                    </IconButton> :
                    <IconButton 
                    onClick={handleLike}
                    aria-label="add to favorites"
                    >
                    <FavoriteIcon style={isLiked? { color: "red" } : null} />
                    </IconButton>
                  }
                    {likeCount}
                    <IconButton
                    className={clsx(classes.expand, {
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
                      <Comment userId = {comment.userId} userName = {comment.userName} text = {comment.text}></Comment>
                    )) : "Loading"}
                    {disabled? "":
                    <CommentForm userId = {localStorage.getItem("currentUser")} userName = {localStorage.getItem("userName")} postId = {postId} setCommentRefresh={setCommentRefresh}></CommentForm>}
                    </Container>
                </Collapse>
                </Card>
   )
}*/

export default Post;

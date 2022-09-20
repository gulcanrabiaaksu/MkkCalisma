import React, {useState} from 'react';
import {Link} from "react-router-dom";
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import Avatar from '@material-ui/core/Avatar';
import Typography from '@material-ui/core/Typography';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import { InputAdornment } from '@material-ui/core';
import Button from '@material-ui/core/Button';
import Snackbar from '@material-ui/core/Snackbar';

import MuiAlert from '@material-ui/lab/Alert';


function Alert(props) {
    return <MuiAlert elevation={6} variant="filled" {...props} />;
  }

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
    //transform:'rotate(180deg)',
  },
  avatar: {
    background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
  },
}));

function PostForm(props){
    const { userId, userName, refreshPosts} = props;
    const classes =useStyles();
    const[title,setTitle] =useState("");
    const[text,setText] =useState("");
    const[isSent,setIsSent] = useState(false);
  
    

const savePost = () => {
    fetch ("/posts",
    {
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify({
            title : title,
            userId : userId,
            text : text,
        }),
    })
    .then((res)=> res.json())
    .catch((err)=> console.log("error"))
}


  const handleSubmit = ()=>{ //objeyi beckende gondermek ıcın bunu kullanıyoruz
    savePost();
    setIsSent(true);
    setTitle("");
    setText("");
    refreshPosts();
  }

  const handleTitle =(value)=>{
    setTitle(value);
    setIsSent(false);

  }

  const handleText =(value)=>{
    setText(value);
    setIsSent(false);

  }
  
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setIsSent(false);
  };

  return(
        <div>
        <Snackbar open={isSent} autoHideDuration={6000} onClose={handleClose}>
     <Alert onClose={handleClose} severity="success">
        This is a success message!
    </Alert>
    </Snackbar>
    <Card className={classes.root}>
      <CardHeader
      avatar ={
      <Link className={classes.link} to = {{pathname :"/users/" + userId}}>
         <Avatar aria-label="recipe"  className={classes.avatar} >
           { userName.charAt(0).toUpperCase()}
          </Avatar>
          </Link>
        }
        title={<OutlinedInput
            id="outlined-adornment-amount"
            multiline
            placeholder = "Title"
            inputProps= {{maxLength : 25}}
            fullWidth
            value = {title}
            onChange={(i)=> handleTitle (i.target.value)}
            >
        </OutlinedInput>} 
        />
      <CardContent>
        <Typography variant="body2" color="textSecondary" component="p">
          {<OutlinedInput
            id="outlined-adornment-amount"
            multiline
            placeholder = "Text"
            inputProps= {{maxLength : 250}}
            fullWidth
            value = {text}
            onChange={(i)=> handleText (i.target.value)}
            endAdornment = {
                <InputAdornment poisiton= "end">
                    <Button
                    variant = "contained"
                    style = { {background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
                    color :'white'}}
                    onClick ={handleSubmit}
                    >Post </Button>
                </InputAdornment>
            }
            >
        </OutlinedInput>}
        </Typography>
      </CardContent>
    </Card>
        </div>
       

  )
}

export default PostForm;

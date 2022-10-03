import React from "react";
import {Link} from "react-router-dom";
import { makeStyles } from '@material-ui/core/styles';
import { CardContent, InputAdornment, OutlinedInput, Avatar} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    comment : {
        display: "flex",
        flexWrap: "wrap",
        justifyContent : "flex-start",
        alignItems : "center",
      },
      small: {
        width: theme.spacing(4),
        height: theme.spacing(4),
      },
      link: {
          textDecoration : "none",
          boxShadow : "none",
          color : "white"
      },
      avatar: {
        background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%)',
    }
  }));

function Comment(props) {
    const {text, userId, userName} = props;
    const classes = useStyles();

    return(
        <CardContent className = {classes.comment}>

        <OutlinedInput
        disabled
        id="outlined-adornment-amount"
        multiline
        inputProps = {{maxLength : 25}}
        fullWidth     
        value = {text} 
        startAdornment = {
            <InputAdornment position="start">
                <Link  className={classes.link} to={{pathname : '/users/' + userId}}>
                    <Avatar aria-label="recipe" className={classes.avatar}>
                        {userName.charAt(0).toUpperCase()}
                    </Avatar>
                </Link>
            </InputAdornment>
        }
        style = {{ color : "black",backgroundColor: 'white'}}
        ></OutlinedInput>
        </CardContent>

    )
}


export default Comment;
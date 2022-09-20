import React, {useState, useEffect} from "react";
import Post from '../Post/Post';
import PostForm from "../Post/PostForm";
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    Container: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent : "center",
        alignItems : "center",
        backgroundColor: '#300000',
        
    }
}));

function Home() 
    {
    const[error,setError]=useState(null); //ilk durumda null, error yok
    const[isLoaded,setIsLoaded]=useState(false); //ilk durumda false
    const[postList,setPostList] =useState([]);
    const classes = useStyles();

    const refreshPosts = ()=> {
        fetch("/posts")//datayı fetch et
        .then(res =>res.json())
        .then(//iki ihtimal var result ve error
            (result) => {
                setIsLoaded(true)//data geldi
                setPostList(result)//gelen resultu ata
            },
            (error) =>{
                console.log(error)
                setIsLoaded(true)//sayfa donerde kalmaz yine true olucak,sayfa geldi
                setError(error)
            }
        )
    }

    useEffect(()=> {
        refreshPosts()
    }, [postList])

    if (error) {//error varsa buaraya girecek
        return <div> Error!!</div>;
        } else if (!isLoaded){//dolmadıysa, yükleniyorsa
            return <div> Loading...</div>;
            } else {
                return (
                <div fixed className= {classes.Container}>
                    <PostForm userId={1} userName={"ddd"} refreshPosts={refreshPosts}/> 
                {postList.map(post => (
                    <Post postId={post.id} userId={post.userId} userName={post.userName} 
                    title={post.title} text={post.text} ></Post>
                    ))}
                </div>
               
            );
    }
}

export default Home;
   

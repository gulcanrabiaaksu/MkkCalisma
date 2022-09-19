import React, {useState, useEffect} from "react";
import Post from '../Post/Post';

/*
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import PostForm from "../Post/PostForm";

const useStyles = makeStyles((theme) => ({
    container: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent : "center",
        alignItems : "center",
        backgroundColor: '#f0f5ff',
    }
}));*/

function Home() 
    {
    const[error,setError]=useState(null); //ilk durumda null, error yok
    const[isLoaded,setIsLoaded]=useState(false); //ilk durumda false
    const[postList,setPostList] =useState([]);

    useEffect(()=> {
        fetch("/posts")//datayı fetch et
        .then(res =>res.json())
        .then(//iki ihtimal var result ve error
        (result) =>{
            setIsLoaded(true);//data geldi
            setPostList(result);//gelen resultu ata
        },
        (error) =>{
            console.log(error)
            setIsLoaded(true);//sayfa donerde kalmaz yine true olucak,sayfa geldi
            setError(error);
        }
        )
    },[])

    if(error){//error varsa buaraya girecek
        return <div> Error!!</div>
        }else if (!isLoaded){//dolmadıysa, yükleniyorsa
            return <div> Loading...</div>
            }else {
                return (
                <div className="container">
                    sdfg     
                {postList.map(post => (
                <Post title={post.title} text={post.text}></Post>))}
                </div>
            );
        }
}

export default Home;
    /*</div>
    /*const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [postList, setPostList] = useState([]);
    const classes = useStyles();


    const refreshPosts = () => {
        fetch("/api/posts")
        .then(res => res.json())
        .then(
            (result) => {
                setIsLoaded(true);
                setPostList(result)
            },
            (error) => {
                console.log(error)
                setIsLoaded(true);
                setError(error);
            }
        )
    }

    useEffect(() => {
        refreshPosts()
    }, [])

    if(error) {
        return <div> Error !!!</div>;
    } else if(!isLoaded) {
        return <div> Loading... </div>;
    } else {
        return(

            <div className = {classes.container}>
                {localStorage.getItem("currentUser") == null? "":
                <PostForm userId = {localStorage.getItem("currentUser")} userName = {localStorage.getItem("userName")}  refreshPosts = {refreshPosts}/>}
                   {postList.map(post => (
                    <Post likes = {post.postLikes} postId = {post.id} userId = {post.userId} userName = {post.userName}  
                    title={post.title} text={post.text}></Post>
                ))}
            </div>
        );
    }
*/
      

import {React} from "react";
import {useParams} from "react-router-dom";//gelen parametrenin degerini almak icin kullaniriz

function User() {
    const {userId} = useParams(); 
    return (
        <div>
            User! {userId}
        </div>
    );   
}
export default User;
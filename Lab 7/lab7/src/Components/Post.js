import {useContext} from "react";
import PostsContext from "../context/PostsContext";

const Post = (props) => {
    const {selected, setSelected } = useContext(PostsContext);

    const handleClick = () => {
        if(selected === props.index){
            setSelected(null);
            return;
        }
        setSelected(props.index)
    };


    return (
        <div className="post" onClick={handleClick} >
            <p>
                id: {props.id}
            </p>
            <p>
                title: {props.title}
            </p>
            <p>
                author: {props.author}
            </p>
        </div>
    );
}

export default Post;
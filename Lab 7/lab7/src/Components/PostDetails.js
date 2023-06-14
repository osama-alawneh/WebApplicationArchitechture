import axios from 'axios';
import React, {useContext, useState} from 'react';
import postsContext from "../context/PostsContext";

const PostDetails = (props) => {
    const { posts, setPosts, selected, setSelected } = useContext(postsContext);
    const [name, setName] = useState("");

    const btnClickHandler = () => {
        if (posts.length > 0) {
            posts[selected].title = name;
            setPosts([...posts]);
            setSelected(null);
            setName("")
        }
    }

    const btnDeleteHandler  = () => {
        const post = posts[selected];
        axios.delete(`http://localhost:8080/api/v1/posts/${post.id}`)
        .then(()=>{
            posts.splice(selected, 1);
            setPosts([...posts]);
        });
        setSelected(null);
    }

    return typeof selected === 'number' ? (
        <div>
            <div className={"postDetails"}>
                <div>
                    <h1>
                        MIU
                    </h1>
                </div>

                <div>
                    {posts[selected].author}
                </div>

                <div>
                    {posts[selected].content}
                </div>
                <div>
                    <div>
                        <button onClick={btnDeleteHandler}>
                            remove
                        </button>
                    </div>
                </div>
            </div>

            <div>
                <button onClick={btnClickHandler}>
                    Change Title
                </button>
                <br />
                <br />
                <input value={name} type="text" onChange={({ target: { value } }) => setName(value) } />
            </div>
        </div>
    ) : null;
};

export default PostDetails;
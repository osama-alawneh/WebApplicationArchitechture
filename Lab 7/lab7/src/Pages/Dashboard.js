import React, {useEffect, useState} from 'react';
import Posts from "../Components/Posts";
import PostDetails from "../Components/PostDetails";
import PostsContext from "../context/PostsContext";
import AddPost from '../Components/AddPost';

const Dashboard = (props) => {
    const [posts, setPosts] = useState([]);
    const [selected, setSelected] = useState(null);
    const [addPostFlag, setAddPostFlag] = useState(false);

    useEffect(() => {
        console.log('rerender')
    }, [posts, selected]);

    const addPostBtnHandler = () => {
        setAddPostFlag(!addPostFlag);
    }

    return (
        <PostsContext.Provider value={{posts, setPosts, selected, setSelected, addPostFlag, setAddPostFlag}} >
            <div>
                <div>
                    <h1>Dashboard</h1>
                    <button onClick={addPostBtnHandler}>
                        Add Post
                    </button>
                </div>
                <div className={"container"}>
                    <Posts />
                </div>
                <div>
                    <PostDetails />
                </div>
                <div>
                    <AddPost />
                </div>
            </div>
        </PostsContext.Provider>
    )
};

export default Dashboard;
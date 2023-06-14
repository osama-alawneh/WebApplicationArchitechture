import Post from "./Post";
import {useContext, useEffect, useState} from "react";
import PostsContext from "../context/PostsContext";
import axios from "axios";



const Posts = () => {
    const { posts, setPosts } = useContext(PostsContext);
    

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/posts')
        .then((response) => {
            setPosts(response.data);
        });
    },[]);

    return posts.map((p, i) => {
        return <Post
            key={p.id}
            id={p.id}
            index={i}
            title={p.title}
            author={p.author}
        />
    });
}

export default Posts;

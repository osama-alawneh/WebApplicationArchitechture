import axios from "axios";
import { useContext, useState } from "react";
import PostsContext from "../context/PostsContext";

const AddPost = () => {
    const [values, setValues] = useState({
        title: "",
        content: "",
        author: ""
    });

    const {addPostFlag, setAddPostFlag, posts ,setPosts} = useContext(PostsContext);

    const handleChange = ({target: {name, value}}) => setValues(prev => ({...prev, [name] : value}));

    const addPostSubmitHandler = (e) =>  {
        e.preventDefault();
        const data = {
            "title" : values.title,
            "content" : values.content,
            "author" : values.author
        };

        axios.post("http://localhost:8080/api/v1/posts", data)
        .then(()=>{
            console.log("data posted");
            setAddPostFlag(false);
            setPosts([...posts, data])
        })
    }

    // const handleChange2 = ({ target: { name, value } }) => {
    //     setValues(prev => {
    //         return { ...prev, [name]: value }
    //     }) 
    // }

    return addPostFlag === true ? (
        <form>
            {/* <label>Title:</label>
            <input name="title" type="text" onChange={({target: {value}}) => setValues({...values, title: value})}/>
            <br /> */}
            
            <label>Title:</label>
            <input name="title" type="text" value={values.title}  onChange={handleChange}/>
            <br />

            <label>Content:</label>
            <input name="content" type="text" value={values.content} onChange={handleChange} />
            <br />

            <label>Author:</label>
            <input name="author" type="text" value={values.author} onChange={handleChange}/>
            <br />

            <button onClick={addPostSubmitHandler}>
                Submit
            </button>
        </form>
    ) : null;

};

export default AddPost
import { useEffect, useState } from "react";
import {
    Routes,
    Route,
} from "react-router-dom";
import CreatePostComponent from "../components/create-post/CreatePostComponent";
import PostComponent from "../components/home/post/PostComponent";
import { Post } from "../model/PostModel";
import { dummyDataPost } from "../service/service";
import data from '../dummy-data/DummyData.json'
const RouterComponet = () => {

    // const [listPost, setListPost] = useState<Array<Post> | undefined>();
    const [listPost, setListPost] = useState<[]>();
    

    // Get API from BE
    // useEffect(() => {
    //     async function run() {
    //         const response = await fetch('');
    //         const result = await response.json();
    //         setListPost(result);
    //     };
    //     run();
    // }, [])

    return (
        <div>
            <Routes>
                <Route path="/" element={listPost && <PostComponent listPost={listPost}/>} />
                <Route path="/create" element={<CreatePostComponent />} />
            </Routes>
        </div>
    )
}

export default RouterComponet

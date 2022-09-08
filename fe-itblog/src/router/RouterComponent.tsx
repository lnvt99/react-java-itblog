import { useEffect, useState } from 'react';

import {
    Routes,
    Route,
} from 'react-router-dom';
import axios from 'axios';

import PostComponent from '../components/home/post/PostComponent';
import CreatePostComponent from '../components/create-post/CreatePostComponent';
import { Post } from '../model/PostModel';
import { dummyDataPost } from '../service/service';

const RouterComponet = () => {

    const [listPost, setListPost] = useState<Array<Post> | undefined>();

    // Get API from BE
    // useEffect(() => {
    //     async function run() {
    //         const response = await fetch('');
    //         const result = await response.json();
    //         setListPost(result);
    //     };
    //     run();
    // }, [])

    useEffect(() => {
        async function getPost() {
            try {
                const response = await axios.get('http://localhost:8080/api/categories');
                console.log(response.data);
            } catch (error) {
                console.error(error);
            }
        }

        getPost()
    })

    return (
        <div>
            <Routes>
                <Route path="/" element={<PostComponent listPost={listPost} />} />
                <Route path="/create" element={<CreatePostComponent />} />
            </Routes>
        </div>
    )
}

export default RouterComponet

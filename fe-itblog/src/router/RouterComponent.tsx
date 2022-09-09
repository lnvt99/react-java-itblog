import { useEffect, useState } from 'react';

import {
    Routes,
    Route,
} from 'react-router-dom';
import axios from 'axios';

import PostComponent from '../components/home/post/PostComponent';
import CreatePostComponent from '../components/create-post/CreatePostComponent';
import { PostModel } from '../model/PostModel';

interface Post {
    currentPage: number,
    totalPage: number,
    listPost: PostModel[]
}

const RouterComponet = () => {

    const [listPost, setListPost] = useState();

    useEffect(() => {
        async function getPost() {
            try {
                const response = await axios.get('http://localhost:8080/api/posts');
                setListPost(response.data)
            } catch (error) {
                console.log(error)
            }
        }

        getPost();
    }, [])


    return (
        <div>
            <Routes>
                <Route path="/" element={listPost && <PostComponent listPost = { listPost }/>} />
                <Route path="/create" element={<CreatePostComponent />} />
            </Routes>
        </div>
    )
}

export default RouterComponet

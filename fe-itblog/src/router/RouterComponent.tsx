import { useEffect, useState } from 'react';

import {
    Routes,
    Route,
} from 'react-router-dom';
import axios from 'axios';

import PostComponent from '../components/home/post/PostComponent';
import CreatePostComponent from '../components/create-post/CreatePostComponent';
import ManagementComponent from '../components/management/ManagementComponent';

const RouterComponet = () => {

    const [listPost, setListPost] = useState();
    const [currentPage, setCurrentPage] = useState(0);
    const [totalPage, setTotalPage] = useState(0);


    useEffect(() => {
        async function getPost() {
            try {
                const response = await axios.get('http://localhost:8080/api/posts');
                setListPost(response.data.postDTOList);
                setTotalPage(response.data.totalPage);
                setCurrentPage(response.data.currentPage);
            } catch (error) {
                console.log(error)
            }
        }

        getPost();
    }, [])


    return (
        <div>
            <Routes>
                <Route path="/" element={listPost && <PostComponent currentPage={ currentPage } totalPage = { totalPage } postDTOList = { listPost }/> } />
                <Route path="/create" element={<CreatePostComponent />} />
                <Route path="/manage" element={listPost && <ManagementComponent postDTOList = { listPost }/>} />
            </Routes>
        </div>
    )
}

export default RouterComponet

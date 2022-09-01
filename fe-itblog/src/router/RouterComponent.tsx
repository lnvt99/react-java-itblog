import {
    Routes,
    Route,
} from "react-router-dom";
import CreatePostComponent from "../components/create-post/CreatePostComponent";
import PostComponent from "../components/home/post/PostComponent";

const RouterComponet = () => {
    return (
        <div>
            <Routes>
                <Route path="" element={<PostComponent />} />
                <Route path="/create" element={<CreatePostComponent />} />
            </Routes>
        </div>
    )
}

export default RouterComponet

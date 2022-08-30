import SearchComponent from "./search/SearchComponent"
import PostComponent from "./post/PostComponent"


const displayPost = () => {
    for (let index = 0; index < 5; index++) {
        return  <PostComponent />
    }
}

const TestScreenHome = () => {
    return (
        <div>
            <div className="flex pb-2 h-12">
                <div className="w-28 font-bold text-2xl text-center ml-3">IT-BLOG</div>
                <div className="w-2/4 flex">
                    <div className="flex-1">
                        <ul className="flex ml-3 justify-around">
                            <li>Home</li>
                            <li>Create Post</li>
                            <li>Admin</li>
                        </ul>
                    </div>
                </div>
                <div className="flex justify-content">
                        <div className="mr-10">
                            <SearchComponent />
                        </div>
                        <div className="">
                        <img className="inline-block h-12 w-12 rounded-full ring-2 ring-white rounded-full border-amber-400" 
                            src="https://play-lh.googleusercontent.com/aFWiT2lTa9CYBpyPjfgfNHd0r5puwKRGj2rHpdPTNrz2N9LXgN_MbLjePd1OTc0E8Rl1" alt=""/>
                        </div>
                    </div>
            </div>
            { displayPost() }
        </div>
    )
}

export default TestScreenHome
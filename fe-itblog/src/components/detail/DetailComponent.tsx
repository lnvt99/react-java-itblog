import { useEffect } from 'react'
import { useParams } from "react-router-dom";
import CommentComponent from "./comment/CommentComponent"
import RelatedPostComponent from "./related-post/RelatedPostComponent"

const DetailComponent = () => {

    const slug = useParams();

    useEffect(() => {
        console.log(slug)
        
      }, []);

    return (
        <div className="container mx-auto">
            <div className="px-10 py-6 mx-auto">
                <div className="italic">
                    {">>"} <a href="#" className="hover:underline"> Home </a>  {">"} <a href="#" className="hover:underline"> Category </a>
                </div>
                <div className="max-w-6xl px-10 py-6 mx-auto">
                    <div className="mt-2">
                        <p className="sm:text-3xl md:text-3xl lg:text-3xl xl:text-4xl font-bold text-dark-500">Trong Javascript cũng có "Typescript" mà bấy lâu nay ta không biết</p>
                    </div>
                    <div className="items-center justify-center mt-4 mb-4">
                    </div>
                    <div className="max-w-4xl px-10  mx-auto text-2xl mt-4 rounded">
                        <div className="font-light">
                            <a href="#" className="flex items-center mt-6 mb-6"><img src="https://avatars.githubusercontent.com/u/71964085?v=4" alt="avatar" className="hidden object-cover w-14 h-14 mx-4 rounded-full sm:block" />
                                <div>
                                    <h1 className="font-bold ">James Amos</h1>
                                    <h1 className="">Time</h1>
                                </div>
                            </a>
                        </div>
                        <img className="mx-auto text-center object-cover h-52 w-full" src="https://files.fullstack.edu.vn/f8-prod/blog_posts/4685/63117986d6356.png" />
                        <div>
                            <p className="mt-2 p-8">Có thể tiêu đề sẽ gây hoang mang cho một số bạn chưa, mới hoặc đã biết về Typescript (TS), chúng mình cùng bắt đầu bài viết để giải đáp thắc mắc nào:

                                Tại sao bài viết này ra đời
                                Dành cho các bạn muốn gán type trong code ReactJS đang sử dụng JS mà dự án đang không xài TS
                                Làm sao để viết “TS” trong JS
                                Đầu tiên chúng ta sẽ tìm hiểu từ khoá PropTypes trong ReactJS

                                1. PropTypes là cái chi chi:
                                Khái niệm Prop trong React thì ắt hẳn các bạn cũng đã biết (ai chưa biết thì mở ngay video của anh Sơn xem nhé).

                                Khi chúng ta truyền Prop từ Component (Com) cha xuống (Com) con thì mỗi Prop có 1 type khác nhau đúng k nè.

                                Chúng ta muốn mỗi Prop đều có type riêng, tránh trường hợp Prop đó là 1 function mà bạn lại truyền object thì có phải “Râu ông này cắm cầm bà kia không” =))</p>
                        </div>
                    </div>
                </div>
                <h2 className="text-2xl mt-4 text-gray-500 font-bold text-center">Related Posts</h2>
                <RelatedPostComponent />
                <CommentComponent />
            </div>
        </div>

    )
}

export default DetailComponent
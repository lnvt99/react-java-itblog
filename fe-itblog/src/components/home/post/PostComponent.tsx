import React from 'react';

import {
    Link
} from 'react-router-dom';

import { Post } from '../../../model/Model'

interface Props {
    postDTOList: Post[],
    currentPage: number,
    totalPage: number,
}

const PostComponent: React.FC<Props> = ({ postDTOList, currentPage, totalPage}) => {

    console.log()

    return (
        <div className="grid grid-cols-2 gap-4 container mx-auto px-4 lg:grid-cols-4 md:grid-cols-3">
            {
                postDTOList && postDTOList.map((item) => (
                    <div key = {item.slug} className=" mt-3 max-w-sm bg-white rounded-lg border border-gray-200 shadow-md dark:bg-gray-800 dark:border-gray-700 container ">
                        <Link to={item.slug} className="flex justify-center">
                            <img className="rounded-t-lg overflow-hidden w-48 h-48 px-4 py-4 " src={item.imgUrl} alt={item.title} />
                        </Link>
                        <div className="p-5">
                            <Link  to={item.slug}>
                                <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">{item.title}</h5>
                            </Link>
                            <p className="mb-3 font-normal text-gray-700 dark:text-gray-400">{item.summary}</p>
                            <Link  to={item.slug} className="inline-flex items-center py-2 px-3 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                Read more
                                <svg aria-hidden="true" className="ml-2 -mr-1 w-4 h-4" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fillRule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clipRule="evenodd" /></svg>
                            </Link>
                        </div>
                    </div>

                ))
            }
        </div>
    )
}

export default PostComponent;
import React from 'react';
import ReactMarkdown from 'react-markdown';
import ReactDom from 'react-dom';

import { useState } from 'react';



const CreatePostComponent: React.FC = () => {

    const [content, setContent] = useState(" ");

    return (
        <div className="mt-3">
            <div>
                <button type="button" className="ml-10 focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">Create</button>
                <button type="button" className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Reset</button>
            </div>
            <ReactMarkdown># Hello, *world*!</ReactMarkdown>
        </div>
    )
}


export default CreatePostComponent
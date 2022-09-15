import React from "react";

import EditPostComponent from './edit-post/EditPostComponent'
import { Post } from '../../model/Model'

interface Props {
    postDTOList: Post[]
}

const ManagementComponent: React.FC<Props> = ({ postDTOList }) => {

    const [showModal, setShowModal] = React.useState<boolean>(false);
    const [item, setItem] = React.useState<string>(' ');

    // Receiving arguments from child component (interface)
    const updateStatusModal = (status: boolean) => {
        setShowModal(status);
    }

    return (
        <div className="flex m-auto container overflow-x-auto relative shadow-md sm:rounded-lg w-4/5 mt-8">
            <div className="flex justify-between items-center py-4 bg-white dark:bg-gray-800">
            </div>
            <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 bg-blue-200">
                    <tr>
                        <th scope="col" className="py-3 px-6">
                            Title
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Category
                        </th>
                        <th scope="col" className="py-3 px-6">
                            Created
                        </th>
                        <th scope="col" className="py-3 px-6 text-center">
                            Action
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        postDTOList && postDTOList.map((item, key) => (
                            <tr key = { key } className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                                <td className="py-4 px-6">
                                    {item.title}
                                </td>
                                <td className="py-4 px-6">
                                    {item.category}
                                </td>
                                <td className="py-4 px-6">
                                    {item.createdAt.toString().slice(0,10)}
                                </td>
                                <td className="py-4 px-6 text-center">
                                    {/* Modal toggle */}
                                    <button className="text-gray-900 bg-gradient-to-r from-teal-200 to-lime-200 hover:bg-gradient-to-l hover:from-teal-200 hover:to-lime-200 focus:ring-4 focus:outline-none focus:ring-lime-200 dark:focus:ring-teal-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2" onClick={() => { setShowModal(true); setItem(item.slug) }}>Update</button>

                                    <button className="text-white bg-gradient-to-br from-pink-500 to-orange-400 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-pink-200 dark:focus:ring-pink-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2">Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
            {showModal ?
                <EditPostComponent show={showModal} item = {item} updateStatusModal={updateStatusModal} /> : null}
        </div>

    )
}

export default ManagementComponent;
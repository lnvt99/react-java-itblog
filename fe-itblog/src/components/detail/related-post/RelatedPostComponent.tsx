const RelatedPostComponent = () => {
    return (
        <div>
            <div className="flex grid h-full grid-cols-12 gap-10 pb-10 mt-8 sm:mt-16">
                <div className="grid grid-cols-12 col-span-12 gap-7">
                    <div className="flex flex-col items-start col-span-12 overflow-hidden shadow-sm rounded-xl md:col-span-6 lg:col-span-4">
                        <a href="#_" className="block transition duration-200 ease-out transform hover:scale-110">
                            <img className="object-cover w-full shadow-sm h-full" src="https://images.unsplash.com/photo-1579621970563-ebec7560ff3e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1951&q=80" />
                        </a>
                        <div className="relative flex flex-col items-start px-6 border border-t-0 border-gray-200 py-7 rounded-b-2xl">
                            <div className=" absolute top-0 -mt-3 flex items-center px-3 py-1.5 leading-none w-auto inline-block rounded-full text-xs font-medium uppercase text-white inline-block">
                                <span>Flask</span>
                            </div>
                            <h2 className="text-base text-gray-500 font-bold sm:text-lg md:text-xl"><a href="#_">Oauth using facebook with flask,mysql,vuejs and tailwind css</a></h2>
                            {/* <p class="mt-2 text-sm text-gray-500">Learn how to authenticate users to your application using facebook.</p> */}
                        </div>
                    </div>
                    <div className="flex flex-col items-start col-span-12 overflow-hidden shadow-sm rounded-xl md:col-span-6 lg:col-span-4">
                        <a href="#_" className="block transition duration-200 ease-out transform hover:scale-110">
                            <img className="object-cover w-full shadow-sm h-full" src="https://images.unsplash.com/photo-1579621970563-ebec7560ff3e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1951&q=80" />
                        </a>
                        <div className="relative flex flex-col items-start px-6 border border-t-0 border-gray-200 py-7 rounded-b-2xl">
                            <div className="absolute top-0 -mt-3 flex items-center px-3 py-1.5 leading-none w-auto inline-block rounded-full text-xs font-medium uppercase text-white inline-block">
                                <span>Django</span>
                            </div>
                            <h2 className="text-base text-gray-500 font-bold sm:text-lg md:text-xl"><a href="#_">Authenticating users with email verification in Django apps</a></h2>
                            {/* <p class="mt-2 text-sm text-gray-500">Learn how to authenticate users to your web application by sending secure links to their email box.</p> */}
                        </div>
                    </div>
                    <div className="flex flex-col items-start col-span-12 overflow-hidden shadow-sm rounded-xl md:col-span-6 lg:col-span-4">
                        <a href="#_" className="block transition duration-200 ease-out transform hover:scale-110">
                            <img className="object-cover w-full shadow-sm h-full" src="https://images.unsplash.com/photo-1579621970563-ebec7560ff3e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1951&q=80" />
                        </a>
                        <div className="relative flex flex-col items-start px-6 border border-t-0 border-gray-200 py-7 rounded-b-2xl">
                            <div className=" absolute top-0 -mt-3 flex items-center px-3 py-1.5 leading-none w-auto inline-block rounded-full text-xs font-medium uppercase text-white inline-block">
                                <span>Flask</span>
                            </div>
                            <h2 className="text-base text-gray-500 font-bold sm:text-lg md:text-xl"><a href="#_">Creating user registration and authentication system in flask</a></h2>
                            {/* <p class="mt-2 text-sm text-gray-500">Learn how to authenticate users to your application using flask and mysql db.</p> */}
                        </div>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default RelatedPostComponent

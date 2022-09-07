import {
    BrowserRouter
} from "react-router-dom";

import HeaderComponent from '../common/header/HeaderComponent'
import RouterComponet from '../../router/RouterComponent';

const HomeComponent = () => {
    return (
        <BrowserRouter>
            <div className="min-h-full">
                <HeaderComponent />
                <hr className="divide-stone-800"></hr>
                <RouterComponet />
            </div>
        </BrowserRouter>
    )
}

export default HomeComponent;
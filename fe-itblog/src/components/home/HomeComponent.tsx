import {
    BrowserRouter
} from "react-router-dom";
import axios from 'axios';
import HeaderComponent from '../common/header/HeaderComponent'
import RouterComponet from '../../router/RouterComponent';
import { useEffect } from "react";

const HomeComponent = () => {

    useEffect(() => {
        async function getPost () {
            try {
                const response = await axios.get('');
                console.log(response);
              } catch (error) {
                console.error(error);
              }
        }
    })

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
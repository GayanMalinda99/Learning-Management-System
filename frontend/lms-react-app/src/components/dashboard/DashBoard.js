import * as React from 'react';
import ResponsiveAppBar from "./ResposiveAppBar";
import axios from "axios";

export default class Dashboard extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            userName:"",
            userId:"",
        }
    }

    // componentDidMount() {
    //     const config = {
    //         headers: {
    //             'Authorization': 'Bearer ' + localStorage.getItem('token')
    //         }
    //     }

    //     axios.get('appuser',config).then(
    //         response => {
    //             console.log(response.data);
    //             console.log(response.data.firstName);
    //             this.setState({userName: response.data.firstName, userId: response.data.id}); 
    //         },
    //         error => {
    //             console.log(error);
    //         }
    //     )
    // }


    render() {
        const {userName, userId} = this.state;
    return(
            <ResponsiveAppBar/> 
    )
    }
}

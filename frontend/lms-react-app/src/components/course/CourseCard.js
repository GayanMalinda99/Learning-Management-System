import './CourseCard.css';
import { Button } from '@mui/material';
import img from '../../image/img.jpg'
import Axios from 'axios';
import React, { useState } from 'react';

function enrollment(params){
    const student_id = localStorage.getItem('id');
    const config = {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
    }
    Axios.put(`course/student/${params}/${student_id}`,{},config)
    .then(res => console.log(res)).catch(err => console.log(err));
}

const CourseCard = ({ courseData }) => {
    return (
        <div className="card">
            <div className="card__image"><img src={img} alt="image"/></div>
            <div className="card__title">{courseData.title}</div>
            <div className="card__body">
                
                <div>{courseData.code}</div>
                <div>{courseData.description}</div>
                <div>{courseData.lecture_id}</div>
            </div>
            <Button variant="contained" color="primary" className="card__btn" onClick={()=>{enrollment(courseData.code)}}>
                Enroll
            </Button>
        </div>
    )
};

export default CourseCard;

// import React from "react";
// import { Typography, Grid, makeStyles, Button, Avatar} from "@mui/material";
// import { createStyles } from '@mui/styles';


// const useStyles = makeStyles(theme => ({
//   page: {
//     padding: theme.spacing(10)
//   },
//   root: {
//     border: `1px solid ${theme.palette.secondary[400]}`,
//     padding: theme.spacing(2),
//     borderRadius: "2px",
//     maxWidth: 200
//   },
//   header: {
//     color: theme.palette.grey[400],
//     height: "15px"
//   },
//   photoContainer: {
//     marginBottom: theme.spacing(1)
//   },
//   avatar: {
//     width: theme.spacing(7),
//     height: theme.spacing(7)
//   },
//   verified: {
//     height: 20
//   },
//   channelUserName: {
//     fontWeight: theme.typography.fontWeightBold
//   },
//   chanelNameContainer: {
//     marginBottom: theme.spacing(1)
//   },
//   followButton: {
//     textTransform: "none",
//     paddingRight: theme.spacing(6),
//     paddingLeft: theme.spacing(6),
//     fontWeight: theme.typography.fontWeightMedium
//   }
// }));

// export default function CourseCard() {
//   const classes = useStyles();

//   return (
//     <div className={classes.page}>
//       <Grid
//         container
//         direction="column"
//         alignItems="center"
//         className={classes.root}
//       >
//         <ChannelPhoto classes={classes} />
//         <ChannelUserName classes={classes} />
//         <ChannelName classes={classes} />
//         <FollowButton classes={classes} />
//       </Grid>
//     </div>
//   );
// };


// const ChannelPhoto = ({ classes }) => {
//   return (
//     <div className={classes.photoContainer}>
//       <Avatar
//         className={classes.avatar}
//         alt="Nat Geo"
//         src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTQqLXPdwanG-kTsMGmC6Ff4lmKkw1LBy4G4G1tYxDNWV-8MCAI&usqp=CAU"
//       />
//     </div>
//   );
// };
// const ChannelUserName = ({ classes }) => {
//   return (
//     <Grid container justify="center" alignItems="center" spacing={5}>
//       <Grid item xs={3}>
//         <Typography variant="body2" className={classes.channelUserName}>
//           natgeo
//         </Typography>
//       </Grid>
//     </Grid>
//   );
// };
// const ChannelName = ({ classes }) => {
//   return (
//     <div className={classes.chanelNameContainer}>
//       <Typography color="textSecondary" variant="caption">
//         National Geographic
//       </Typography>
//     </div>
//   );
// };
// const FollowButton = ({ classes }) => {
//   return (
//     <Button
//       disableElevation
//       color="primary"
//       variant="contained"
//       size="small"
//       className={classes.followButton}
//     >
//       Follow
//     </Button>
//   );
// };
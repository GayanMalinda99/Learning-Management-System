import { useState, useEffect } from "react";
import CourseCard from "./CourseCard";
import './ViewCourses.css';
import axios from "axios";

function ViewCourses() {

    const [allCourses, setAllCourses] = useState([]);
    const [Courses, setCourses] = useState([]);
  
    useEffect(() => {
      axios.get('http://localhost:8080/api/v1/course/getcourse')
      .then(res =>
        {
        setAllCourses(res.data);
        setCourses(res.data);
      }, 
    err => { 
        console.log(err);
      })
    },[]);
  
    const filterCards = event => {
      const value = event.target.value.toLowerCase();
      const filteredCourses = allCourses.filter(course => (`${course.title}`.toLowerCase().includes(value)));
      setCourses(filteredCourses);
    }
  
    return (
      <div className="Main">
        <h1>Course</h1>
        <input className="search-box" onInput={filterCards} placeholder="Search..."/>
        <div className="cards-container">
  
        {Courses.map((course, index) => (
          <CourseCard key={index} courseData={course} />
          ))}
        </div>
      </div>
    );
  }
  

export default ViewCourses;
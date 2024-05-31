import React from "react";
import HeroImage from "../../images/lms.jpg";
import "./Home.css";


const home = () => {
    return (
        <div className="container">
            <img src={HeroImage} alt="Learning Management System" />
        </div>
    );
};

export default home;
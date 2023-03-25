import React from 'react';
import '../css/Navbar.css';

export default function Navbar(props) {

    function showSingleWorkoutForm() {
        props.setShowWorkoutForm(true)
        props.setShowSplitForm(false)
        props.setShowDatabase(false)
        props.setShowSearch(false)
        props.setShowAbout(false)
        props.setShowLogin(false)
    }

    function showWeeklyWorkoutForm() {
        props.setShowWorkoutForm(false)
        props.setShowSplitForm(true)
        props.setShowDatabase(false)
        props.setShowSearch(false)
        props.setShowAbout(false)
        props.setShowLogin(false)
    }

    function showDatabase() {
        props.setShowWorkoutForm(false)
        props.setShowSplitForm(false)
        props.setShowDatabase(true)
        props.setShowSearch(false)
        props.setShowAbout(false)
        props.setShowLogin(false)
    }

    return (
        <nav className="navbar">
            <button
                className="navButton--singleForm"
                id="singleForm"
                onClick={showSingleWorkoutForm}
                >Single Workout Form</button>
            <button
                className="navButton--weeklyForm"
                id="weeklyForm"
                onClick={showWeeklyWorkoutForm}
                >Weekly Workout Form</button>
            <button
                className="navButton--database"
                id="database"
                onClick={showDatabase}
                >Full Exercise Database</button>
            <button className="navButton--search">Search for Exercise</button>
            <button className="navButton--about">About</button>
            <button className="navButton--login">Login</button>
        </nav>
    )
}
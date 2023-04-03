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
                >single workout</button>
            <button
                className="navButton--weeklyForm"
                id="weeklyForm"
                onClick={showWeeklyWorkoutForm}
                >weekly workout</button>
            <button
                className="navButton--database"
                id="database"
                onClick={showDatabase}
                >all exercises</button>
            <button
                className="navButton--search"
                id="search"

                >search</button>
            <button
                className="navButton--about"
                id="about"

                >about</button>
            <button
                className="navButton--login"
                id="login"

                >
                <img src={require('../css/img/login.png')} alt="login"/>
                login</button>
        </nav>
    )
}
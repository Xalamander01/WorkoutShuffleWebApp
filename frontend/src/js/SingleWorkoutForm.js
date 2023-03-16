import React from 'react';
import ListWorkout from './ListWorkout';
import '../css/SingleWorkoutForm.css';

export default function SingleWorkoutForm() {

    const [singleWorkoutType, setSingleWorkoutType] = React.useState(null)
    const [submittedWorkoutType, setSubmittedWorkoutType] = React.useState(null)

    function handleChange(event) {
        const {value} = event.target
        setSingleWorkoutType(value)
    }

    function handleSubmit(event) {
        event.preventDefault()
        setSubmittedWorkoutType(singleWorkoutType)
    }

    console.log("FROM SINGLE WORKOUT FORM")

    return (
        <div key="SingleWorkoutForm" className="singleWorkoutForm">
            { submittedWorkoutType == null ? <div> <h3>Get a single workout</h3>
            <form onSubmit={handleSubmit} >
                <fieldset>
                    <legend>Today I would like to train</legend>
                    <input type="radio" id="push" name="workoutType" value="push" checked={singleWorkoutType === "push"} onChange={handleChange} />
                    <label htmlFor="push">Push</label><br/>
                    <input type="radio" id="pull" name="workoutType" value="pull" checked={singleWorkoutType === "pull"} onChange={handleChange} />
                    <label htmlFor="pull">Pull</label><br/>
                    <input type="radio" id="upper" name="workoutType" value="upper" checked={singleWorkoutType === "upper"} onChange={handleChange} />
                    <label htmlFor="upper">Push and Pull</label><br/>
                    <input type="radio" id="legs" name="workoutType" value="legs" checked={singleWorkoutType === "legs"} onChange={handleChange} />
                    <label htmlFor="legs">Legs</label><br/>
                    <input type="radio" id="fullBody" name="workoutType" value="fullBody" checked={singleWorkoutType === "fullBody"} onChange={handleChange} />
                    <label htmlFor="fullBody">Full Body</label><br/>
                </fieldset>
                <input type="submit" value="Submit"/>
            </form> </div> : null }
            { submittedWorkoutType != null ? <ListWorkout key="ListWorkout" workoutType={submittedWorkoutType} setWorkoutType={setSubmittedWorkoutType} /> : null }
        </div>
    );
}

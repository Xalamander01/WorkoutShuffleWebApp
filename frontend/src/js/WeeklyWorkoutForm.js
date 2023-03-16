import React from 'react';
import ListWorkout from './ListWorkout';
import '../css/WeeklyWorkoutForm.css';

export default function WeeklyWorkoutForm() {

    const [weeklyWorkoutTypes, setWeeklyWorkoutTypes] = React.useState(null)
    const [submittedWorkoutTypes, setSubmittedWorkoutTypes] = React.useState(null)

    return (
        <div key="WeeklyWorkoutForm" className="weeklyWorkoutForm">
            { submittedWorkoutTypes == null ? <div> <h3>Get a weekly split</h3> </div> : null }
        </div>
    )
}
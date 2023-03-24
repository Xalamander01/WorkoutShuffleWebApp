import React from 'react';
import ListWorkout from './ListWorkout';
import '../css/ListManyWorkouts.css';

export default function ListManyWorkouts(props) {

    const workouts = props.workouts
    const [workoutIndex, setWorkoutIndex] = React.useState(0)
    const [workoutsListElement, setWorkoutListElement] = React.useState(<ListWorkout workout={workouts[workoutIndex].exerciseList} />)

    React.useEffect(()=>setWorkoutListElement(
                            <ListWorkout workout={workouts[workoutIndex].exerciseList} />
                        ),[workoutIndex,workouts])

    const workoutsListButtons = workouts.map(workoutTypeAndList=> {
            return (
                <button key={workoutTypeAndList.workoutType + workouts.indexOf(workoutTypeAndList)} onClick={()=>setWorkoutIndex(workouts.indexOf(workoutTypeAndList))} >
                    {getButtonText(workoutTypeAndList.workoutType)} Day {workouts.indexOf(workoutTypeAndList)+1}
                </button>
            )
        })

    function getButtonText(workoutTypeToFix) {

        let workoutTypeToReturn = ""

        for (let i = 0; i < workoutTypeToFix.length; i++) {
            let character = workoutTypeToFix.charAt(i)
            if ( i === 0 ) {
                character = workoutTypeToFix.charAt(i).toUpperCase()
            } else if ( workoutTypeToFix.charAt(i) === workoutTypeToFix.charAt(i).toUpperCase() ) {
                character = " " + workoutTypeToFix.charAt(i)
            }
            workoutTypeToReturn = workoutTypeToReturn.concat(character)
        }
        return workoutTypeToReturn
    }

    return (
        <div className="listManyWorkouts">
            <div className="listManyButtons">
                {workoutsListButtons}
            </div>
            {workoutsListElement}
        </div>
    )
}
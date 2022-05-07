import './CourseCard.css';

const CourseCard = ({ courseData }) => {
    return (
        <div className="card">
            <div className="card__title">{courseData.title}</div>
            <div className="card__body">
                <div>{courseData.code}</div>
                <div>{courseData.description}</div>
            </div>

        </div>
    )
};

export default CourseCard;
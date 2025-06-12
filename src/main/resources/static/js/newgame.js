let correctCount = 0;
let incorrectCount = 0;
const answeredQuestions = {};

function checkAnswer(questionId, selected, correct) {
    if (answeredQuestions[questionId] !== undefined) {
        if (answeredQuestions[questionId] === 'correct' && selected !== correct) {
            correctCount--;
            incorrectCount++;
            answeredQuestions[questionId] = 'incorrect';
        } else if (answeredQuestions[questionId] === 'incorrect' && selected === correct) {
            correctCount++;
            incorrectCount--;
            answeredQuestions[questionId] = 'correct';
        }
    } else {
        if (selected === correct) {
            correctCount++;
            answeredQuestions[questionId] = 'correct';
        } else {
            incorrectCount++;
            answeredQuestions[questionId] = 'incorrect';
        }
    }

    document.getElementById('correctCount').textContent = correctCount;
    document.getElementById('incorrectCount').textContent = incorrectCount;
}

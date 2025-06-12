let currentIndex = 0;
let totalQuestions = 1;

function loadQuestions(select) {
    totalQuestions = parseInt(select.options[select.selectedIndex].getAttribute('data-limit')) || 1;
    currentIndex = 0;
    generateQuestionFields();
    updateQuestionLabel();
    showCurrentQuestion();
}

function prevQuestion() {
    if (currentIndex > 0) {
        currentIndex--;
        updateQuestionLabel();
        showCurrentQuestion();
    }
}

function nextQuestion() {
    if (currentIndex < totalQuestions - 1) {
        currentIndex++;
        updateQuestionLabel();
        showCurrentQuestion();
    }
}

function updateQuestionLabel() {
    document.getElementById('questionLabel').innerText = `Question ${currentIndex + 1}`;
}

function generateQuestionFields() {
    const container = document.querySelector('.question-form');
    container.innerHTML = ''; // vymaž staré polia

    for (let i = 0; i < totalQuestions; i++) {
        const div = document.createElement('div');
        div.className = 'question-block';
        div.dataset.index = i;
        div.style.display = 'none'; // skryj všetky, len jeden bude viditeľný

        div.innerHTML = `
            <input type="text" name="questions[${i}].question" placeholder="Enter question" required />
            <input type="text" name="questions[${i}].optionA" placeholder="Answer A" required />
            <input type="text" name="questions[${i}].optionB" placeholder="Answer B" required />
            <input type="text" name="questions[${i}].optionC" placeholder="Answer C" required />
            <input type="text" name="questions[${i}].optionD" placeholder="Answer D" required />
            <input type="text" name="questions[${i}].correct" placeholder="Correct (A/B/C/D)" maxlength="1" required />
        `;
        container.appendChild(div);
    }
}

function showCurrentQuestion() {
    document.querySelectorAll('.question-block').forEach((block, i) => {
        block.style.display = i === currentIndex ? 'block' : 'none';
    });
}

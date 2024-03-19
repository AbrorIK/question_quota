
function fetchQuestions() {
    fetch('/api/questions')
        .then(response => response.json())
        .then(data => {
            const questionsList = document.getElementById('questionsList');
            questionsList.innerHTML = '';
            data.forEach(question => {
                const listItem = document.createElement('li');
                listItem.textContent = `${question.id}: ${question.title}`;
                questionsList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error:', error));
}

function addNewAnswer(event) {
    event.preventDefault();
    const form = document.getElementById('answerForm');
    const formData = new FormData(form);
    const answerData = {};
    formData.forEach((value, key) => {
        answerData[key] = value;
    });

    fetch(`/api/questions/${answerData.questionId}/answers`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ content: answerData.content }),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            alert('Answer added successfully!');
            form.reset();
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error adding answer');
        });
}

// Fetch questions when the page loads
window.onload = fetchQuestions;

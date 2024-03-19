function getQuestions() {
    fetch('/api/questions')
        .then(response => response.json())
        .then(data => {
            const questionsList = document.getElementById('questionsList');
            questionsList.innerHTML = '';
            data.forEach(question => {
                const listItem = document.createElement('li');
                listItem.textContent = `${question.title}: ${question.text}`;
                questionsList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error:', error));
}

function addNewQuestion(event) {
    event.preventDefault();
    const form = document.getElementById('questionForm');
    const formData = new FormData(form);
    const questionData = {};
    formData.forEach((value, key) => {
        questionData[key] = value;
    });

    fetch('/api/questions', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Ensure the correct content type
        },
        body: JSON.stringify(questionData),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            alert('Question added successfully!');
            form.reset();
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error adding question');
        });
}
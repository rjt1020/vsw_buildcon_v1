document.addEventListener('DOMContentLoaded', () => {

    // 1. Scroll-Reveal Animations (Intersection Observer)
    // Ensures a "gorgeous" visual experience on all devices.
    const reveals = document.querySelectorAll('.hidden-reveal');
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('show-reveal');
            }
        });
    }, { threshold: 0.1 }); // Reveal when 10% visible

    reveals.forEach(el => observer.observe(el));


    // 2. Inquiry Form AJAX Submission
    const form = document.getElementById('inquiryForm');
    const status = document.getElementById('formStatus');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        status.textContent = 'Sending...';

        const data = {
            name: document.getElementById('name').value,
            email: document.getElementById('email').value,
            message: document.getElementById('message').value
        };

        try {
            const response = await fetch('/api/inquiry/submit', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });

            const result = await response.text();
            if (result === 'success') {
                status.textContent = 'Thank you! Inquiry sent successfully.';
                form.reset();
            } else {
                status.textContent = 'Error: ' + result;
            }
        } catch (error) {
            status.textContent = 'Submission failed. Please email us directly.';
            console.error('Submission Error:', error);
        }
    });
});
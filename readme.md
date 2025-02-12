# Updated Code for the Spring:Spring Security course

This repository was created to provide an up-to-date version of the example code from the course. The original code has been modified and adapted to ensure compatibility with Spring Security 6 and Spring Boot 3.

## Chapters

Each chapter in the course corresponds to a separate branch in this repository. The latest implementations and necessary updates are reflected in each branch to align with current framework changes.

## OAuth Configuration (Chapter 4)

For the files related to Chapter 4, the application.properties file contains placeholders instead of actual GitHub OAuth credentials (client-id and client-secret).

To set up OAuth authentication correctly:

Go to your GitHub profile settings.

Navigate to Developer settings > OAuth Apps.

Register a new OAuth application and obtain your Client ID and Client Secret.

Replace the placeholders in the application.properties file:

```
spring.security.oauth2.client.registration.github.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_CLIENT_SECRET 
```

For more details, refer to the course videos, where the setup process is explained step by step.
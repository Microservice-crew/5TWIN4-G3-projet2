# Stage 1: Build the Angular application
FROM node:16.15 AS builder

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install
# Copy the rest of your application code
COPY . .
# Build the Angular application
RUN npm run build --prod

CMD ["npm", "start"]

# Stage 2: Create the Nginx image to serve the built app
FROM nginx:alpine
# Copy the Nginx configuration
COPY src/ngnix/etc/conf.d/default.conf /etc/nginx/conf.d/default.conf

COPY --from=builder ./usr/src/app/dist/summer-workshop-angular /usr/share/nginx/html
# Copy the build artifacts from the builder stage
#COPY --from=builder app/dist/summer-workshop-angular /usr/share/nginx/html

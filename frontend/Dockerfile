 
FROM node:alpine3.12 AS front

WORKDIR /usr/src/front 
COPY . .
RUN ["npm", "install"]
RUN ["npm", "run", "build"]

FROM mhart/alpine-node:14

RUN yarn global add serve
WORKDIR /app
COPY --from=front /usr/src/front/build  .
CMD ["serve", "-p", "3000", "-s", "."]
#!/bin/bash

# using this ****

# chmod +x post_request.sh
# ./post_request.sh

# ******

# URL for the API
url="http://localhost:8080/api/stem"

# The sentence to send in the POST request
sentence="burada deneme text var falan"

# Making the POST request with curl
response=$(curl -s -X POST "$url" \
  -H "Content-Type: text/plain" \
  --data "$sentence")

# Print the response
echo "$response"

# TrelloAPITests
API tests for testing Trello using cucumber and rest assured. Just example with 2 tests
Tests:
- Get boards list
- Create new Board with static name, if board with such name exists we delete board and create new one.

Use https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/ for generating your Key and token, also you can use Trello API documentation for creating your tests https://developer.atlassian.com/cloud/trello/rest/api-group-boards/#api-boards-id-get.

I used GET, POST request. For using this project you need to update constants: key, token, member_id.

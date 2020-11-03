# transformerBattle

## Setup

This project uses Spring Boot and Maven. We can manage Transformers and select some to 'Fight' in a battle. The battles conform to a set of rules that can be found in the document 'ProjectInformation.pdf' in the source.

To deploy:

Clone Project.

Run Maven Clean, Test, Package in your IDE or terminal.

Run the 'TransformersApplication' in your IDE.

The project deploys locally to localhost:8080.

There is no UI for the project, just RESTful endpoints listed below.

You can look at the H2 database by going to http://localhost:8080/h2-console.
There is no password so just login.

### Endpoints

#### Get a Transformer -
_GET - /transformers/{id}_

_id_ is the id of the Transformer you want to retrieve

#### Create a Transformer
_POST - /transformers_

**Body example** 

Integers can be 1-10, 

Type is "A" or "D"

```json
{
        "name": "name",
        "type": "D",
        "strength": 1,
        "intelligence": 1,
        "endurance": 1,
        "speed": 1,
        "rank": 1,
        "courage": 1,
        "firepower": 1
}
```
#### Update a Transformer
PUT - /transformers/{id}

**Body example**

Integers can be 1-10, 
Must supply an Id to update the transformer

Type is "A" or "D"

```json
{
    "id": 1,
    "name": "name",
    "type": "D",
    "strength": 1,
    "intelligence": 1,
    "endurance": 1,
    "speed": 1,
    "rank": 1,
    "courage": 1,
    "firepower": 1
}
```
#### Delete a Transformer
DELETE - /transformers/{id}

_id_ is the id of the Transformer you want to delete

#### Get a list of Transformers
GET - /transformers

gets a list of all Transformers

#### Transformer Battle
POST - /battle

Post a list of Transformer Ids to battle

You can use multiple transformers to battle

```json

  [1,2,3]

```

# Assumptions
The requirement "Otherwise, if one of the fighters is 3 or more points of **skill** above their opponent, they win the fight regardless of overall rating" seemed wrong. 
There is a rule about the Skill(Overall Rating), so I assumed "Otherwise, if one of the fighters is 3 or more points of **rank** above their opponent,
                                                                                                                                              they win the fight regardless of overall rating."
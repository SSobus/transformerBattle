# transformerBattle

# Endpoints

###Get a Transformer - 
_GET - /transformers/{id}_

_id_ is the id of the Transformer you want to retrieve

###Create a Transformer 
_POST - /transformers_

**Body example** 

Integers can be 1-10, 

Type is "A" or "D"

```json
{
    "transformer": {
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
}
```

PUT - /transformers/{id}

**Body example**

Integers can be 1-10, 

Type is "A" or "D"

```json
{
    "transformer": {
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
}
```

DELETE - /transformers/{id}

_id_ is the id of the Transformer you want to delete

GET - /transformers

gets a list of all Transformers

POST - /battle

Post a list of Transformer Ids to battle

You can use multiple transformers to battle

```json
{
  "transformerIds": [1,2,3]
}
```

# Assumptions
The requirement "Otherwise, if one of the fighters is 3 or more points of **skill** above their opponent, they win the fight regardless of overall rating" seemed wrong. 
There is a rule about the Skill(Overall Rating), so I assumed "Otherwise, if one of the fighters is 3 or more points of **rank** above their opponent,
                                                                                                                                              they win the fight regardless of overall rating."
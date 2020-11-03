# transformerBattle

# Endpoints

GET - /transformers/{id}

POST - /transformers

PUT - /transformers/{id}

DELETE - /transformers/{id}

GET - /transformers

POST - /battle

# Assumptions
The requirement "Otherwise, if one of the fighters is 3 or more points of **skill** above their opponent, they win the fight regardless of overall rating" seemed wrong. 
There is a rule about the Skill(Overall Rating) so I assumed "Otherwise, if one of the fighters is 3 or more points of **rank** above their opponent,
                                                                                                                                              they win the fight regardless of overall rating"
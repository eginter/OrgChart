# OrgChart

## Initial structure: 
******************************************
#### Employee [id=1, firstName=Elijah, ]
#### Employee [id=2, firstName=Joe, nextEmployee=Tim, supervisor=Elijah]
#### Employee [id=3, firstName=Tim, prevEmployee=Joe, supervisor=Elijah]
#### Employee [id=4, firstName=Sara, nextEmployee=Tom, supervisor=Joe]
#### Employee [id=5, firstName=Tom, prevEmployee=Sara, supervisor=Joe]
#### Employee [id=6, firstName=Sue, nextEmployee=Frank, supervisor=Tim]
#### Employee [id=7, firstName=Frank, prevEmployee=Sue, nextEmployee=Ed, supervisor=Tim]
#### Employee [id=8, firstName=Ed, prevEmployee=Frank, supervisor=Tim]
******************************************

## after calling reassign(supervisor, newPrevEmployee, newNextEmployee)
## frank.reassign(elijah, joe, tim);

******************************************
#### Employee [id=1, firstName=Elijah, ]
#### Employee [id=2, firstName=Joe, nextEmployee=Frank, supervisor=Elijah]
#### Employee [id=3, firstName=Tim, prevEmployee=Frank, supervisor=Elijah]
#### Employee [id=4, firstName=Sara, nextEmployee=Tom, supervisor=Joe]
#### Employee [id=5, firstName=Tom, prevEmployee=Sara, supervisor=Joe]
#### Employee [id=6, firstName=Sue, nextEmployee=Ed, supervisor=Tim]
#### Employee [id=7, firstName=Frank, prevEmployee=Joe, nextEmployee=Tim, supervisor=Elijah]
#### Employee [id=8, firstName=Ed, prevEmployee=Sue, supervisor=Tim]
******************************************

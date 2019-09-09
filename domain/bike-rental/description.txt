# Bike rental system

We want to build a system which allows users to rent bikes (for a given 
period of time).

## Features

1. Rent a bike
2. Return a bike
3. Rental payments

### Examples

Feature: renting a bike

Scenario:
    given:
    User who registered an account with 100 pln on balance.
    when:
    rent a bike
    then:
    can rent a bike without a time limit

Scenario:
    given:
    User who registed an account with 100 pln on balance
    when:
    rent a bike and not return on estimated time (max 6 hours)
    then:
    financial penalty is issued
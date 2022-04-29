#  1,2,3,4,5, 1,2,3,4,5
#  2,1,2,3,2,4,2,5, 2,1,2,3,2,4,2,5 (홀=2, 짝=1,2,3,4,5)
#  3,3,1,1,2,2,4,4,5,5, 3,3,1,1,2,2,4,4,5,5 

def solution(answers):
    person1 = [1,2,3,4,5]
    person2 = [2,1,2,3,2,4,2,5]
    person3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]
    result = []

    for i,answer in enumerate(answers):
        if answers == person1[i%len(person1)]:
            score[0] += 1
        if answers == person2[i%len(person2)]:
            score[1] += 1
        if answers == person3[i%len(person2)]:
            score[2] += 1
        
    for i,s in enumerate(score):
        if s == max(score):
            result.append(i+1)
            break
    
    return result
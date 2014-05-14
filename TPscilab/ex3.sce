clf;
function y = suivant(x,p)
    k=rand();
    if k>p then
        if x<9 then
            y=x+1;
        else
            y=0;
        end;
    else
        y=x;
    end;
endfunction
p=0.5;
A=[0];
for i=1:120
    A(1,i+1)=suivant(A(1,i),p);
end;
x=linspace(0,120,121);
//plot2d(x,A);
//show_window;
A=[];
function t=T(p)
    A=[0]
    A(1,2)=suivant(A(1,1),p);
    i=2;
    while A(1,i)>0
        A(1,i+1)=suivant(A(1,i),p);
        i=i+1;
    end
    t=i;
endfunction
P=[];
for j=1:3000
    P(1,j)=T(p);
end
disp(mean(P));
disp(variance(P));
for k=1:1000
    x=0;
    for i=1:2000
        x=suivant(x,p);
    end
    A(1,k)=x;
end;
histplot(floor(sqrt(1000)),A);
show_window;
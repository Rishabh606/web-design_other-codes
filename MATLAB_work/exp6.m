clc; 
clear all;
close all;
n=input('Enter choice ');
switch(n)
    case 1
        sig= @(t) exp(-t/2);
        period=pi;
        a0=integral(sig,0,pi)/pi;
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        for i=1:1:200
            sign= @(t) exp(-t/2).*(sin(2*(i)*t));
            an(i)=2*integral(sign,0,period)/pi;
        end;

        for i=1:1:200
            sign= @(t) exp(-t/2).*(cos(2*(i)*t));
            bn(i)=2*integral(sign,0,period)/pi;
        end;
        figure;
        subplot(2,2,1);
        stem(an);
        xlabel('Coefficients of sin');
        subplot(2,2,2);
        stem(bn);
        subplot(2,2,3);
        t=linspace(0,pi,200);
        stem(sig(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+(an(j))*sin(2*(j)*t(i));
                g(i)=g(i)+(bn(j))*cos(2*(j)*t(i));
            end;
            g(i)=g(i)+a0;
        end;
        stem(g);
    case 2
            sig= @(t) t/2;
            period=1;
            a0=integral(sig,0,1);
            disp(a0);
            an=zeros(1,200);
            bn=zeros(1,200);
            for i=1:1:200
                sign= @(t) (t/2).*(sin((2*pi*i)*t));
                an(i)=2*integral(sign,0,period)/1;
            end;

            for i=1:1:200
                sign= @(t) (t/2).*(cos((2*pi*i)*t));
                bn(i)=2*integral(sign,0,period)/1;
            end;
            subplot(2,2,1);
        stem(an);
        subplot(2,2,2);
        xlabel('Coefficients of sin');
        stem(bn);
        subplot(2,2,3);
        t=linspace(0,1,200);
        stem(sig(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+an(j)*sin((2*pi*j)*t(i));
                g(i)=g(i)+bn(j)*cos((2*pi*j)*t(i));
            end;
            g(i)=g(i)+a0;
        end;
        stem(g);
        sig= @(t) t/2;
    case 3
        sig1= @(t) (t/t);
        sig2= @(t) -(t/t);
        period=4;
        %a0=integral(sig1,-1,-0.01)+integral(sig2,0.01,3);
        a0=0;
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) 1.*(sin((pi/2*i)*t));
            sign2= @(t) -1.*(sin((pi/2*i)*t));
            an(i)=2*(integral(sign1,-1,1)+integral(sign2,1,3))/4;
        end;

        for i=1:1:200
            sign1= @(t) 1.*(cos((pi/2*i)*t));
            sign2= @(t) -1.*(cos((pi/2*i)*t));
            bn(i)=2*(integral(sign1,-1,1)+integral(sign2,1,3))/4;
        end;

        figure;
        subplot(2,2,1);
        stem(an);
        xlabel('Coefficients of sin');
        subplot(2,2,2);
        stem(bn);
        subplot(2,2,3);
        t=linspace(-1,3,200);
        %disp(t);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=-1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+an(j)*sin(pi/2*(j)*t(i));
                g(i)=g(i)+bn(j)*cos(pi/2*(j)*t(i));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
    case 4
        sig1= @(t) (t);
        sig2= @(t) -(t)+2*pi;
        period=4;
        a0=(integral(sig1,0,pi)+integral(sig2,pi,2*pi))/(2*pi);
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) t.*(sin((i)*t));
            sign2= @(t) (-t+2*pi).*(sin((i)*t));
            an(i)=2*(integral(sign1,0,pi)+integral(sign2,pi,2*pi))/(2*pi);
        end;

        for i=1:1:200
            sign1= @(t) t.*(cos((i)*t));
            sign2= @(t) (-t+2*pi).*(cos((i)*t));
            bn(i)=2*(integral(sign1,0,pi)+integral(sign2,pi,2*pi))/(2*pi);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an)
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(tn);
        subplot(2,2,3);
        t=linspace(0,2*pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=pi)
                res(i)=sig1(t(i));
            else
                res(i)=sig2(t(i));
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                %g(i)=g(i)+an(j)*sin((j)*t(i));
                %g(i)=g(i)+bn(j)*cos((j)*t(i));
                g(i)=g(i)+cn(j)*cos(pi-j*t(i)+tn(j));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
%         stem(t(1:100),g(101:200));
%         hold on;
%         ax=gca;
%         ax.ColorOrderIndex=1;
%         stem(t(101:200),g(1:100));
%         hold off;
   case 5
        sig1= @(t) sin(t);
        period=4;
        a0=(integral(sig1,0,pi))/(pi);
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) sin(t).*(sin((2*i)*t));
            an(i)=2*(integral(sign1,0,pi))/(pi);
        end;

        for i=1:1:200
            sign1= @(t) sin(t).*(cos((2*i)*t));
            bn(i)=2*(integral(sign1,0,pi))/(pi);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(tn);
        subplot(2,2,3);
        t=linspace(0,pi,200);
        stem(t,sig1(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                %g(i)=g(i)+an(j)*sin((2*j)*t(i));
                %g(i)=g(i)+bn(j)*cos((2*j)*t(i));
                 g(i)=g(i)+cn(j)*cos(pi-(2*j)*t(i)+tn(j));
                 %g(i)=-g(i);
            end;
           g(i)=g(i)+a0;
        end;
        stem(t,g);
%         stem(t(101:200),g(1:100));
%         hold on;
%         ax=gca;
%         ax.ColorOrderIndex=1;
%         stem(t(1:100),g(101:200));
%         hold off;
    case 6
        sig1= @(t) sin(t);
        period=4;
        a0=(integral(sig1,0,pi))/(2*pi);
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) sin(t).*(sin((i)*t));
            an(i)=2*(integral(sign1,0,pi))/(2*pi);
        end;

        for i=1:1:200
            sign1= @(t) sin(t).*(cos((i)*t));
            bn(i)=2*(integral(sign1,0,pi))/(2*pi);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn)
        stem(tn);
        subplot(2,2,3);
        t=linspace(0,2*pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=pi)
                res(i)=sig1(t(i));
            else
                res(i)=0;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                %g(i)=g(i)+an(j)*sin((j)*t(i));
                %g(i)=g(i)+bn(j)*cos((j)*t(i));
                g(i)=g(i)+cn(j)*cos(pi-(j*t(i)+tn(j)));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
    case 7
        sig1= @(t) (2/pi)*t;
        a0=(integral(sig1,-pi,pi))/(2*pi);
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) (2/pi)*(t).*(sin((i)*t));
            an(i)=2*(integral(sign1,-pi,pi))/(2*pi);
        end;

        for i=1:1:200
            sign1= @(t) (2/pi)*(t).*(cos((i)*t));
            bn(i)=2*(integral(sign1,-pi,pi))/(2*pi);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(tn);
        subplot(2,2,3);
        t=linspace(-pi,pi,200);
        res=zeros(1,200);
        stem(t,sig1(t));
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+an(j)*sin((j)*t(i));
                g(i)=g(i)+bn(j)*cos((j)*t(i));
                %g(i)=g(i)+cn(j)*cos((j)*t(i)+tn(j));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
     case 8
        a0=0;
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) 1.*(sin(pi/2*(i)*t));
            sign2= @(t) -1.*(sin(pi/2*i*t)); 
            an(i)=2*(integral(sign1,-1,1)+integral(sign2,1,3))/(4);
        end;

        for i=1:1:200
            sign1= @(t) 1.*(cos(pi/2*(i)*t));
            sign2= @(t) -1.*(cos(pi/2*(i)*t));
            bn(i)=2*(integral(sign1,-1,1)+integral(sign2,1,3))/(4);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        stem(cn)
        %stem(an);
        subplot(2,2,2);
        %stem(bn);
        stem(tn);
        subplot(2,2,3);
        t=linspace(-1,3,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=1)
                res(i)=1;
            else
                res(i)=-1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+an(j)*sin(pi/2*(j)*t(i));
                g(i)=g(i)+bn(j)*cos(pi/2*(j)*t(i));
                %g(i)=g(i)+cn(j)*cos(j*t(i)+tn(j));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
      case 9
        a0=0.5;
        disp(a0);
        an=zeros(1,200);
        bn=zeros(1,200);
        cn=zeros(1,200);
        tn=zeros(1,200);
        for i=1:1:200
            sign1= @(t) 1.*(sin((i)*t)); 
            an(i)=2*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;

        for i=1:1:200
            sign1= @(t) 1.*(cos((i)*t));
            bn(i)=2*(integral(sign1,-pi/2,pi/2))/(2*pi);
        end;
        
        for i=1:1:200
            cn(i)=sqrt(an(i)*an(i)+bn(i)*bn(i));
            tn(i)=atan(-an(i)/bn(i));
        end;
        figure;
        subplot(2,2,1);
        %stem(an);
        stem(cn);
        subplot(2,2,2);
        %stem(bn);
        stem(tn);
        subplot(2,2,3);
        t=linspace(-pi,pi,200);
        res=zeros(1,200);
        for i=1:200
            if(t(i)<=-pi/2||t(i)>pi/2)
                res(i)=0;
            else
                res(i)=1;
            end;
        end;
        stem(t,res);
        subplot(2,2,4);
        g=zeros(1,200);
        for i=1:1:200
            for j=1:1:200
                g(i)=g(i)+an(j)*sin((j)*t(i));
                g(i)=g(i)+bn(j)*cos((j)*t(i));
                %g(i)=g(i)+cn(j)*cos(j*t(i)+tn(j));
            end;
            g(i)=g(i)+a0;
        end;
        stem(t,g);
end;